package xyz.taoqz.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.taoqz.demo.entity.User;
import xyz.taoqz.demo.service.IUserService;
import xyz.taoqz.demo.vo.PageRequest;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Tao
 * @since 2019-11-21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 分页查询
     * @param pageRequest
     * @return
     */
    @GetMapping("/page")
    public List<User> findByPage(PageRequest pageRequest){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
//        如果查询条件存在,使用模糊查询 否则正常查询
        if (null != pageRequest.getKey() && !("").equals(pageRequest.getKey().trim())){
            userQueryWrapper.like("name", pageRequest.getKey());
        }
        return iUserService.page(new Page<>(pageRequest.getPageNum(),pageRequest.getPageSize()),userQueryWrapper).getRecords();
    }

    /**
     * 通过id获取
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id){
//        User user = new User();
//        user.setId(id);
//        return iUserService.getOne(new QueryWrapper<>(user));
        return iUserService.getById(id);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public String removeById(@PathVariable Integer id){
        iUserService.removeById(id);
        return id+"删除成功";
    }

    /**
     * 批量删除 ids=1,2
     * @param ids
     * @return
     */
    @DeleteMapping
    public String removeByIds(@RequestParam List<Integer> ids){
        iUserService.removeByIds(ids);
        return "批量删除成功";
    }

    /**
     * 添加并返回id
     * @param user
     * @return 自增后的id
     */
    @PostMapping
    public int add(@RequestBody User user){
        iUserService.save(user);
        return user.getId();
    }

    /**
     * 修改
     * @param user
     * @return
     */
    @PutMapping
    public User edit(@RequestBody User user){
        iUserService.updateById(user);
        return user;
    }

}

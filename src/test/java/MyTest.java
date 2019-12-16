import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.taoqz.MyApplication;
import xyz.taoqz.demo.entity.User;
import xyz.taoqz.demo.service.IUserService;

/**
 * @author :almostTao
 * @date :Created in 2019/11/21 15:13
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class MyTest {

    @Autowired
    private IUserService iUserService;

    @Test
    public void demo(){
        User user = new User();
//        分页查询加条件 所有字段为空正常查询
        user.setAge(20);
        IPage<User> page = iUserService.page(new Page<User>(1, 3),new QueryWrapper<User>(user));
        page.getRecords().forEach(System.out::println);
    }

}

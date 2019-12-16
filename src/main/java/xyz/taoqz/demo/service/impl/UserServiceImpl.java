package xyz.taoqz.demo.service.impl;

import xyz.taoqz.demo.entity.User;
import xyz.taoqz.demo.mapper.UserMapper;
import xyz.taoqz.demo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tao
 * @since 2019-11-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}

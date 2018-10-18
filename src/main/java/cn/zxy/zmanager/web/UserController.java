package cn.zxy.zmanager.web;

import java.util.List;

import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.annotation.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

import cn.zxy.zmanager.support.common.ZManagerResult;
import cn.zxy.zmanager.dao.dataobject.ZUser;
import cn.zxy.zmanager.service.ZUserService;

/**
 * @author Silence 000996
 * @data 18/9/12
 */
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private ZUserService userService;

	@PostMapping("add")
	public ZManagerResult<ZUser> addUser(@RequestBody ZUser user) {
		return userService.addUser(user);
	}

	@PostMapping("delete/{id}")
	public ZManagerResult deleteUser(@PathVariable Integer id) {
		return userService.deleteUserByPrimaryKey(id);
	}

	@PostMapping("update")
	public ZManagerResult<ZUser> updateUser(@RequestBody ZUser user) {
		return userService.updateUser(user);
	}

	@GetMapping("get")
	public ZManagerResult<List<ZUser>> listUsers(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize, String account, String name, @User LoginUser loginUser) {
		PageHelper.startPage(pageNum, pageSize);
		ZUser user = new ZUser();
		user.setAccount(account);
		user.setName(name);
		return userService.listUsers(user);
	}

}

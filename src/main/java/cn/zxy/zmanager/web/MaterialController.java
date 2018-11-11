package cn.zxy.zmanager.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.zxy.zmanager.dao.dataobject.ZMaterial;
import cn.zxy.zmanager.service.ZMaterialService;
import cn.zxy.zmanager.support.LoginUser;
import cn.zxy.zmanager.support.annotation.User;
import cn.zxy.zmanager.support.common.ZManagerResult;

/**
 * @author Silence 000996
 * @data 18/9/12
 */
@RestController
@RequestMapping("material")
public class MaterialController {

	@Autowired
	private ZMaterialService materialService;
	
	@PostMapping("add")
	public ZManagerResult<?> addMaterial(@RequestBody ZMaterial material, @User LoginUser loginUser) {
		return materialService.addMaterial(material, loginUser);
	}
	
	// 只能修改物资名，类型，规格，存储地址和备注
	@PostMapping("update")
	public ZManagerResult<?> updMaterial(@RequestBody ZMaterial material, @User LoginUser loginUser) {
		return materialService.updMaterial(material, loginUser);
	}

	@GetMapping("list")
	public ZManagerResult<List<ZMaterial>> listMaterial(@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "10") int pageSize, String keyWord) {
		return materialService.listMaterial(pageNum, pageSize, keyWord);
	}
	

}

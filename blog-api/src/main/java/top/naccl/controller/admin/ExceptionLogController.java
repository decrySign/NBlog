package top.naccl.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.naccl.entity.ExceptionLog;
import top.naccl.model.vo.Result;
import top.naccl.service.ExceptionLogService;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Description: 异常日志后台管理
 * @Author: Naccl
 * @Date: 2020-12-04
 */
@RestController
@RequestMapping("/admin")
public class ExceptionLogController {
	@Autowired
	ExceptionLogService exceptionLogService;

	/**
	 * 分页查询异常日志列表
	 *
	 * @param date     按操作时间查询
	 * @param pageNum  页码
	 * @param pageSize 每页个数
	 * @return
	 */
	@GetMapping("/exceptionLogs")
	public Result exceptionLogs(@RequestParam(defaultValue = "") String[] date,
	                            @RequestParam(defaultValue = "1") Integer pageNum,
	                            @RequestParam(defaultValue = "10") Integer pageSize) {
		String startDate = null;
		String endDate = null;
		if (date.length == 2) {
			startDate = date[0];
			endDate = date[1];
		}
		String orderBy = "create_time desc";
		PageHelper.startPage(pageNum, pageSize, orderBy);
		PageInfo<ExceptionLog> pageInfo = new PageInfo<>(exceptionLogService.getExceptionLogListByDate(startDate, endDate));
		return Result.ok("请求成功", pageInfo);
	}


	/**
	 * 上传图片
	 *
	 * @param file 上传的图片文件
	 * @return 上传结果
	 */
	@PostMapping("/uploadImage")
	public Result uploadImage(@RequestParam("file") MultipartFile file) {
		// 校验文件是否为空
		if (file.isEmpty()) {
			return Result.error("文件不能为空");
		}

		// 获取当前日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy" + File.separator + "MM");
		String datePath = sdf.format(new Date());

		// 构建存储目录
		String uploadDir = "/www/wwwroot/uploads" + File.separator + datePath;
		File dir = new File(uploadDir);
		if (!dir.exists()) {
			dir.mkdirs(); // 创建文件夹
		}

		// 构建文件名，避免文件名重复
		String originalFilename = file.getOriginalFilename();
		String extension = StringUtils.getFilenameExtension(originalFilename); // 获取文件扩展名
		String filename = UUID.randomUUID().toString() + "." + extension;

		// 存储文件
		File dest = new File(dir, filename);
		try {
			file.transferTo(dest);
		} catch (IOException e) {
			return Result.error("文件上传失败: " + e.getMessage());
		}

		// 返回文件路径
		String filePath = "/uploads" + File.separator + datePath + File.separator + filename;
		return Result.ok("上传成功", filePath);
	}
	/**
	 * 按id删除异常日志
	 *
	 * @param id 日志id
	 * @return
	 */
	@DeleteMapping("/exceptionLog")
	public Result delete(@RequestParam Long id) {
		exceptionLogService.deleteExceptionLogById(id);
		return Result.ok("删除成功");
	}
}

package com.fresh.freshgrouponsystem.controller;

import com.fresh.freshgrouponsystem.common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController {

    // 图片保存路径：resources/productImg 目录
    private static final String UPLOAD_DIR = System.getProperty("user.dir")
            + "/src/main/resources/productImg/";

    @PostMapping("/upload")
    public Result<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
        // 1. 校验文件
        if (file.isEmpty()) {
            throw new RuntimeException("上传的文件不能为空");
        }

        // 2. 生成唯一文件名（避免重名覆盖）
        String originalName = file.getOriginalFilename();
        String suffix = originalName.substring(originalName.lastIndexOf("."));
        String newFileName = UUID.randomUUID() + suffix;

        // 3. 保存文件到 productImg 目录
        File uploadFolder = new File(UPLOAD_DIR);
        if (!uploadFolder.exists()) {
            uploadFolder.mkdirs(); // 不存在则创建
        }
        File destFile = new File(uploadFolder, newFileName);
        file.transferTo(destFile);

        // 4. 返回可访问的图片地址（和下面yml配置对应）
        String imgUrl = "http://localhost:8080/productImg/" + newFileName;
        return Result.success("文件上传成功", imgUrl);
    }
}
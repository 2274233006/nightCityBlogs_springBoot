package com.nightCityBlogs.utils;

import com.nightCityBlogs.mapper.UserMapper;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

public class COSUploadUtil {
    @Autowired
    private UserMapper userMapper;
    // 初始化用户身份信息
    String secretId = "AKID5STFn78yc1A5kALkwwlNjpgHchX8vVqz";
    String secretKey = "zkGXt20kFUVNDUXKsHalkZDettfDWcZI";
    // 地域
    String bucketRegion = "ap-shanghai";
    // bucket名称
    String bucketName = "nightcityblogs-1312951467";
    //根据需要设置，参考官方文档
    String basicPath = "";

    public String upLoadFile2COS(Long fileSize, String filename, MultipartFile file, String userid) throws IOException {
        // 创建cos客户端
        System.out.println("创建COS客户端...");
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        Region region = new Region(bucketRegion);
        //ClientConfig 中包含了后续请求 COS 的客户端设置
        System.out.println("配置COS...");
        ClientConfig clientConfig = new ClientConfig(region);
        COSClient cosClient = new COSClient(cred, clientConfig);
        // 获取输入流
        System.out.println("获取输入流...");
        InputStream inputStream = new BufferedInputStream(file.getInputStream());
        ObjectMetadata objectMetadata = new ObjectMetadata();
        System.out.println("配置输入流...");
        // 设置输入流长度为500
        // 这里要强调一下，因为腾讯云支持本地文件上传和文件流上传，为了不必要的麻烦所以选择文件流上传，根据官方文档，为了避免oom，必须要设置元数据并告知输入流长度
        objectMetadata.setContentLength(fileSize);

        // 具体用法参考官方文档
        System.out.println("文件上传中...");
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, basicPath + userid + "/" + filename, inputStream, objectMetadata);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        System.out.println("上传完成...正在关闭输入流即COS连接");
        // 完成上传之后，关闭连接
        destory(cosClient);
        inputStream.close();

//         通过回调函数判断是否上传成功，有etag信息则表示上传成功，否则上传失败
        if (putObjectResult.getETag() != null) {
            System.out.println("COS上传成功！正在输出URL");
            Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000); // 5小时
            URL url = cosClient.generatePresignedUrl(bucketName, basicPath + userid + "/" + filename, expiration);
            System.out.println(url.toString());
            return url.toString();
        } else {
            System.out.println("COS上传失败");
            return "false";
        }
    }

    // 关闭连接
    public void destory(COSClient cosClient) {
        cosClient.shutdown();
    }
}
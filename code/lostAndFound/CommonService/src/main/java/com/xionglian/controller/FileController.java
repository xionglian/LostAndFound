package com.xionglian.controller;

import com.xionglian.common.response.ResMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by  xionglian on 2018-05-08.
 */
@Controller
@RequestMapping("/File")
public class FileController {
    @RequestMapping(value="uploadPhoto")
    @ResponseBody
    public ResMessage uploadPhotoes(@RequestParam MultipartFile uploadFile, HttpServletRequest request){
        ResMessage resMessage = new ResMessage();
        try {
            if(!uploadFile.isEmpty()){

                String filename = uploadFile.getOriginalFilename();
                //分割文件前缀和文件类型
                String prefix =  filename.substring(0, filename.lastIndexOf("."));
                String fileType = filename.substring(filename.lastIndexOf(".")+1);
                //文件格式判断
                if(-1 == "jpg,jpeg,gif,png,bmp,psd".indexOf(fileType.toLowerCase())){
                    resMessage.setResult("fail");
                    resMessage.setData("文件不为jpg,jpeg,gif,png,bmp,psd");
                    return resMessage;
                }
                //文件大小
                if(uploadFile.getSize() > 1024 * 1024 * 30){//30M
                    resMessage.setResult("fail");
                    resMessage.setData("文件超过3M");
                    return resMessage;
                }
                //项目部署路径/upload/orderEvaluateFile
				String basePath = //request.getSession().getServletContext().getRealPath("/")
						 "/usr/local/springboot/upload" + File.separator ;

                if(!new File(basePath).exists()){
                    new File(basePath).mkdirs();
                }
                //完整路径
                String picUrl = prefix +"_"+ System.currentTimeMillis() +"."+fileType;
                String savePath = basePath + picUrl;
                //保存
                uploadFile.transferTo(new File(savePath));

                resMessage.setResult("success");
                resMessage.setData("http://master.yuxingyue.cn/File/downloadPhoto?path="+picUrl);
            }else{
                resMessage.setResult("success");
                resMessage.setData("文件为空");
            }

        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            resMessage.setResult("fail");
            resMessage.setData(e.getMessage());
        }
        return resMessage;
    }
    /**
     * 接口功能描述：下载图片
     * @param
     * @return
     */
    @RequestMapping(value="downloadPhoto")
    public ResponseEntity download(HttpServletRequest request){
        ResponseEntity<byte[]> entity = null;
        try{
            String path = null == request.getParameter("path")?"":request.getParameter("path").toString();
            //项目部署路径/
            String basePath = //request.getSession().getServletContext().getRealPath("/")
            		"/usr/local/springboot/upload" + File.separator ;
            File file = new File(basePath+path);
            byte[] body = null;
            InputStream is = new FileInputStream(file);
            body = new byte[is.available()];
            is.read(body);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attchement;filename=" + file.getName());
            HttpStatus statusCode = HttpStatus.OK;
            entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        }catch(Exception e){
            e.printStackTrace();
            entity = null;
        }finally{
            return entity;
        }


    }
}

package com.zz.demo.controller;

import com.zz.demo.entity.App;
import com.zz.demo.service.AppService;
import com.zz.demo.service.AppShowAll;
import com.zz.demo.util.PageMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("app")
public class AppController {
    @Autowired
    private Map<String, AppShowAll> appShowAllMap;
    @Autowired
    private AppService appService;

    @RequestMapping("showAll")
    /*
     * @Param   find      访问的app类别
     * @return  {'code' : 200,
     *           'data' : {'app':app}
     *          }
     */
    public PageMap<App> showAll(Integer pageNum, Integer pageSize, String find) {
        System.out.println ("find = " + find);
        AppShowAll appShowAll = appShowAllMap.get (find);
        PageMap<App> map = appShowAll.showAll (pageNum, pageSize);
        return map;
    }

    @RequestMapping("add")
    /*
     * @Param   find      访问的app类别
     * @return  {'code' : 200,
     *           'data' : {'app':app}
     *          }
     */
    public Map<String, Object> add(App app, MultipartFile file, HttpServletRequest request) {
        String filename = "images/" + UUID.randomUUID ( ) + file.getOriginalFilename ( );
        String path = request.getSession ( ).getServletContext ( ).getRealPath ("/") + filename;
        File dest = new File (path);

        if (!dest.getParentFile ( ).exists ( )) {
            dest.getParentFile ( ).mkdirs ( );
        }

        Map<String, Object> map = new HashMap<> ( );
        try {
            app.setImg (filename);
            file.transferTo (dest);
            appService.add (app);
            map.put ("code", 200);
        } catch (IOException e) {
            e.printStackTrace ( );
            map.put ("code", 500);
            map.put ("message", "文件异常");
        } catch (Exception e) {
            map.put ("code", 500);
        }
        return map;
    }
}
package com.zz.demo.controller;

import com.zz.demo.entity.App;
import com.zz.demo.service.app.AppService;
import com.zz.demo.service.app.AppShowAll;
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

    @RequestMapping("delete")
    /*
     * @Param   find      访问的app类别
     * @return  {'code' : 200,
     *           'data' : {'app':app}
     *          }
     */
    public Map<String, Object> delete(Integer id) {
        Map<String, Object> map = new HashMap<> ( );

        return map;
    }

    @RequestMapping("add")
    /*
     * @Param   find      访问的app类别
     * @return  {'code' : 200,
     *           'data' : {'app':app}
     *          }
     */
    public Map<String, Object> add(App app, MultipartFile imgfile, MultipartFile hreffile, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<> ( );
        try {
            if (hreffile != null) {
                String href = upload ("document/", request, hreffile);
                app.setHref (href);
            }
            String img = upload ("div_images/", request, imgfile);
            app.setImg (img);
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

    private String upload(String pathfather, HttpServletRequest request, MultipartFile file) throws IOException {
        String filename = pathfather + UUID.randomUUID ( ) + file.getOriginalFilename ( );
        String path = request.getSession ( ).getServletContext ( ).getRealPath ("/") + filename;
        File dest = new File (path);

        if (!dest.getParentFile ( ).exists ( )) {
            dest.getParentFile ( ).mkdirs ( );
        }
        file.transferTo (dest);
        return filename;
    }
}

package Phone.controll;



import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import Phone.services.PhoneServicesImpl;
import Phone.pojo.phone_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class MyController {
    @Autowired
    PhoneServicesImpl phoneServicesImpl;


    @RequestMapping("/getPage")//分页查询全部数据
    public String getAll(Model model,
                         @RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "3") Integer pageSize) {
        PageInfo<phone_type> all = phoneServicesImpl.getAllPhoneTypes(pageIndex, pageSize);
        model.addAttribute("page", all);
        model.addAttribute("path", "/getPage?pageIndex=");
        return "pageshowindex";
    }

 //增加数据
 @PostMapping("/create")
 public String createPhoneType(@RequestBody phone_type phoneType,Model model) {
     // 在这里调用服务类的方法来创建手机类型
     phoneServicesImpl.createPhoneType(phoneType);
     PageInfo<phone_type> all = phoneServicesImpl.getAllPhoneTypes(1,3);
     model.addAttribute("page",all); // 将数据库查询结果存储在 list 中
     // 重定向到手机类型列表页面或其他适当的页面
     return "redirect:/getPage";
 }

//删除
    @GetMapping("/delete/{id}")
    public String deletePhoneType(@PathVariable int id ,Model model) {
        phoneServicesImpl.deletePhoneType(id);

        PageInfo<phone_type> all = phoneServicesImpl.getAllPhoneTypes(1,3);
        model.addAttribute("page",all); // 将数据库查询结果存储在 list 中
        return "redirect:/getPage";
    }

    //更新

    @GetMapping("/updata/{id}")
    public String editPhoneType(@PathVariable("id") int id, Model model) {
        // 根据ID从数据库中获取要编辑的手机类型数据
        phone_type phoneType = phoneServicesImpl.getPhoneTypeById(id);

        // 将手机类型对象添加到模型中，以便在编辑页面中使用
        model.addAttribute("phoneType", phoneType);
        model.addAttribute("path", "/getPage?pageIndex=");
        // 返回编辑页面的视图名称
        return "updata"; // 这里假设编辑页面的视图名称为 "editPhoneType.html"
    }


   @RequestMapping("updataok")
   public String editPhoneType(Model model ,phone_type phone_type) {
       // 根据ID从数据库中获取要编辑的手机类型数据
       phoneServicesImpl.updatePhoneType(phone_type);

       PageInfo<phone_type> all = phoneServicesImpl.getAllPhoneTypes(1,3);
       model.addAttribute("page",all); // 将数据库查询结果存储在 list 中
       // 返回编辑页面的视图名称
       return "redirect:/getPage";
   }

//不完全查询姓名方法
  /*  @RequestMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
    // 调用服务层方法进行模糊查询
    PageInfo<phone_type> searchResults = phoneServicesImpl.(query);
        System.out.println(searchResults);
    // 将搜索结果传递给模板
    model.addAttribute("page", searchResults);

    // 返回搜索结果页面
    return "pageshowindex";
}
*/


    @RequestMapping("/tocreate")
    public String tocreate(){
        return "create";}
}

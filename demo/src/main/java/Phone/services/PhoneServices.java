package Phone.services;

import com.github.pagehelper.PageInfo;
import Phone.pojo.phone_type;
import java.util.List;

public interface PhoneServices {
    //查询全部
    PageInfo<phone_type> getAllPhoneTypes(Integer pageIndex, Integer pageSize);

    //增加
    void createPhoneType(phone_type phoneType);
    //删除
    void deletePhoneType(int id);
    PageInfo<phone_type> dataqueryAll(Integer pageIndex, Integer pageSize);

    //更新
     void updatePhoneType(phone_type phoneType);

    //根据id查询
    phone_type getPhoneTypeById(int id);
    //数据库的展示

}

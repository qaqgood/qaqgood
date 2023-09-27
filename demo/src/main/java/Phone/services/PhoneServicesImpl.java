package Phone.services;


import Phone.pojo.phone_type;
import Phone.mapper.PhoneMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;

@Service
public class PhoneServicesImpl implements PhoneServices {

    @Autowired
    PhoneMapper phoneMapper;








    //不完全信息查询DataBase
   /* @Override
    public PageInfo<phone_type> queryBylittle(String message) {
        PageHelper.startPage(1, 3);
        List<phone_type> all= phoneMapper.queryBylittle(message);
        PageInfo<phone_type> orderall=new PageInfo<>(all);
        return orderall;
    }
*/
    @Override //分页查询全部数据
    public PageInfo<phone_type> getAllPhoneTypes(Integer pageIndex,Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<phone_type> all = phoneMapper.getAllPhoneTypes();
        PageInfo<phone_type> orderPageInfo = new PageInfo<>(all);
        return orderPageInfo;
    }

    @Override
    public void createPhoneType(phone_type phoneType) {
        phoneMapper.createPhoneType(phoneType);
    }

    @Override
    public void deletePhoneType(int id) {
        phoneMapper.deletePhoneType(id);
    }

    @Override
    public PageInfo<phone_type> dataqueryAll(Integer pageIndex, Integer pageSize) {
        return null;
    }

    @Override
    public void updatePhoneType(phone_type phoneType) {
        phoneMapper.updatePhoneType(phoneType);
    }

    @Override
    public phone_type getPhoneTypeById(int id) {
       return phoneMapper.getPhoneTypeById(id);

    }
}

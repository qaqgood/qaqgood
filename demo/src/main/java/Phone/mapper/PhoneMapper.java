package Phone.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import Phone.pojo.phone_type;
import java.util.List;

@Mapper
@Repository
public interface PhoneMapper {
    //查询
    List<phone_type> getAllPhoneTypes();

    //根据id查询
     phone_type getPhoneTypeById(int id);
    //添加数据
     void createPhoneType(phone_type phoneType);


     //删除数据
     void deletePhoneType(int id);
     //更新数据
     void updatePhoneType(phone_type phoneType);

}

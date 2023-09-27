package Phone.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class phone_type {
   private int type_id;
   private String number_part;
   private String type_name;
   private String type_remark;
}

package pojo;

import lombok.Data;

/**
 * 货物类
 * */
@Data
public class CarGo {
    //注意：属性必须与数据库表中字段一一对应，缺一不可（如缺少standard属性，则会报错：java.lang.NoSuchFieldException: standard）

    private static final long serialVersionUID = 1L;
    // id 主键
    private Integer id;
    // 名称
    private String name;

    private String standard;

    private String pic;

    private String number;

    // 位置
    private String location;
    // 描述
    private String introduction;



//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getIntroduction() {
//        return introduction;
//    }
//
//    public void setIntroduction(String introduction) {
//        this.introduction = introduction;
//    }
}

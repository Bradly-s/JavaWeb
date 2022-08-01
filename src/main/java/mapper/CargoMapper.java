package mapper;

import pojo.CarGo;

import java.util.List;

public interface CargoMapper {

    /**
     * 查询所有
     */
    List<CarGo> selectAll();
}

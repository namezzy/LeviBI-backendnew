package top.withlevi.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.withlevi.model.entity.Chart;

import java.util.List;
import java.util.Map;

/**
 * @author Hello World
 * @description 针对表【chart(图表信息表)】的数据库操作Mapper
 * @createDate 2024-02-27 17:14:58
 * @Entity generator.domain.Chart
 */
public interface ChartMapper extends BaseMapper<Chart> {

    /**
     * 方法的返回类型是  List<Map<String, Object>>
     *  表示返回的是一个由多个map组合成的集合，每个map代表一行查询结果
     *  并将其封装成了一组键值对形式的对象, 其中String类型代表了键的类型为字符串
     *  Object 类型代表了值的类型为任意对象， 使得这个方法可以适应不同类型的数据查询
     * @param querySql
     * @return
     */

    List<Map<String, Object>> queryChartData(String querySql);

}





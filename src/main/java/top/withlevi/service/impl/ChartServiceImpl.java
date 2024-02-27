package top.withlevi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.withlevi.mapper.ChartMapper;
import top.withlevi.model.entity.Chart;
import top.withlevi.service.ChartService;
import org.springframework.stereotype.Service;

/**
* @author Hello World
* @description 针对表【chart(图表信息表)】的数据库操作Service实现
* @createDate 2024-02-27 14:23:58
*/
@Service
public class ChartServiceImpl extends ServiceImpl<ChartMapper, Chart>
    implements ChartService{

}





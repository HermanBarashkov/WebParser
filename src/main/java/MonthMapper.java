import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MonthMapper {
    MonthMapper INSTANCE = Mappers.getMapper(MonthMapper.class);
    @Mapping(target = "month1", source = "month1")
    @Mapping(target = "month2", source = "month2")
    @Mapping(target = "month3", source = "month3")
    @Mapping(target = "month4", source = "month4")
    @Mapping(target = "month5", source = "month5")
    @Mapping(target = "month6", source = "month6")
    @Mapping(target = "month7", source = "month7")
    @Mapping(target = "month8", source = "month8")
    @Mapping(target = "month9", source = "month9")
    @Mapping(target = "month10", source = "month10")
    @Mapping(target = "month11", source = "month11")
    @Mapping(target = "month12", source = "month12")
    @Mapping(target = "yaer1_5", source = "yaer1_5")
    @Mapping(target = "year2", source = "year2")
    @Mapping(target = "year3", source = "year3")
    MonthPOJO mapToMonthPOJO(String month1, String month2, String month3, String month4,String month5,String month6,
                             String month7,String month8,String month9,String month10,String month11,String month12,
                             String year1_5, String year2, String year3);
}

package me.fit.model.client;

import jakarta.persistence.*;

@Entity
@NamedQueries(
        {
                @NamedQuery(name = HolidayType.GET_TYPES_FOR_HOLIDAY, query = "Select t from HolidayType t where t.holiday.id = :holidayId")
        }
)
public class HolidayType{

    public static final String GET_TYPES_FOR_HOLIDAY = "HolidayType.getTypesForHoliday";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeName;
    @ManyToOne
    private HolidayResponse holiday;


    public HolidayType() {
    }

    public HolidayType(String typeName, HolidayResponse holiday) {
        this.typeName = typeName;
        this.holiday = holiday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HolidayResponse getHoliday() {
        return holiday;
    }

    public void setHoliday(HolidayResponse holiday) {
        this.holiday = holiday;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "HolidayType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", holiday=" + holiday +
                '}';
    }
}

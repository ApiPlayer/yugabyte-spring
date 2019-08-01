package com.yugabyte.springdemo.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
public class WeeklyAdInfo
{
    private String displayName;

    private String priceString;

    private String startDate;

    private String endDate;

    private String weeklyFlyer;

    private String circular;

}

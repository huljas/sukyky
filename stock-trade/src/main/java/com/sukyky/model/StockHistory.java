package com.sukyky.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockHistory {

    @JsonIgnore
    public List<Integer> prices = new ArrayList<Integer>();

    @JsonIgnore
    private List<String> dateLabels = new ArrayList<String>();

    public StockHistory(Object[] history) {
        int[] ia = (int[]) history[0];
        for (int price : ia) {
            prices.add(new Integer(price));
        }
        Date[] dates = (Date[]) history[1];
        for (Date date : dates) {
            dateLabels.add(new LocalDate(date).toString());
        }
    }

    @JsonProperty
    public String getStart() {
        return dateLabels.get(0);
    }

    @JsonProperty
    public String getEnd() {
        return dateLabels.get(dateLabels.size() - 1);
    }

    @JsonProperty
    public List<Integer> getPrices() {
        return prices;
    }
}



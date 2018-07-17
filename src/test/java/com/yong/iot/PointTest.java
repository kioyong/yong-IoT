package com.yong.iot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
public class PointTest {

    @Test
    public void test() {
        calPoints();
    }

    public void calPoints() {
        BigDecimal turnoverDollar = BigDecimal.valueOf(2649.0);
        BigDecimal theoDollar = BigDecimal.valueOf(157.61);
        BigDecimal actualWinDollar = BigDecimal.valueOf(2649.0)
            .subtract(BigDecimal.valueOf(4407.3))
            .setScale(2,RoundingMode.HALF_UP);
        log.debug("actualWinDollar = {}",actualWinDollar);
    }
}

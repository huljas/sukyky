package com.sukyky.setup;

import com.sukyky.model.Stock;
import com.sukyky.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

/**
 * @author huljas
 */
public class DataInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);
    
    @Value("classpath:stocks.yaml")
    private Resource stocksFile;
    
    @Autowired
    private StockRepository stockRepository;

    @PostConstruct
    public void init() throws IOException {
        if (stockRepository.findAllStocks().isEmpty()) {
            populateStocks();
        }
    }

    @Transactional
    public void populateStocks() throws IOException {
        logger.info("Populating stocks from file {}", stocksFile.getFilename());
        Constructor constructor = new Constructor();
        constructor.addTypeDescription(new TypeDescription(Stock.class, "!stock"));
        Yaml yaml = new Yaml(constructor);
        for (Object stock : yaml.loadAll(stocksFile.getInputStream())) {
            stockRepository.save((Stock)stock);
        }
        logger.info("Stocks saved OK!");
    }
}

package guru.springframework.config;

import guru.springframework.repositories.AuthorRepository;
import guru.springframework.repositories.ProductCategoryRepository;
import guru.springframework.repositories.ProductRepository;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GaugeConfig {


    @Bean
    public Gauge countAuthors(MeterRegistry registry, AuthorRepository authorRepository){
        return Gauge.builder("authors.count", authorRepository::count).register(registry);
    }


    @Bean
    public Gauge countProducts(MeterRegistry registry, ProductRepository productRepository){
        return Gauge.builder("products.count", productRepository::count).register(registry);
    }

    @Bean
    public Gauge countCategories(MeterRegistry registry, ProductCategoryRepository categoryRepository){
        return Gauge.builder("categories.count", categoryRepository::count).register(registry);
    }
}

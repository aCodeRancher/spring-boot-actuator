package guru.springframework.actuator.infoContributor;

import guru.springframework.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class TotalProductsInfoContributor implements InfoContributor {
    @Autowired
    ProductRepository productRepository;

    @Override
    public void contribute(Info.Builder builder){
        builder.withDetail("number of products", productRepository.count());
    }
}

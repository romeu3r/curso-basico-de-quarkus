package org.romeu3r;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.dataset.DataSet;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

@DBRider
@QuarkusTest
@QuarkusTestResource(DataBaseLifeCycle.class)
public class ProdutoTeste {

    @Test
    @DataSet("org/romeu3r/produtos1.yml")
    public void testeUm() {
        Assert.assertEquals(1, Produto.count());
    }
}

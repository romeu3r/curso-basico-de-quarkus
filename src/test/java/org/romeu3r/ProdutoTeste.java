package org.romeu3r;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

@QuarkusTest
@QuarkusTestResource(DataBaseLifeCycle.class)
public class ProdutoTeste {

    @Test
    public void testeUm() {
        Assert.assertEquals(1, Produto.count());
    }
}

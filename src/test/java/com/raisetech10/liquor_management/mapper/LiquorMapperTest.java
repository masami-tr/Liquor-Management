package com.raisetech10.liquor_management.mapper;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import com.raisetech10.liquor_management.entity.Liquor;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class LiquorMapperTest {

    @Autowired
    LiquorMapper liquorMapper;


    //READ機能 DBテスト
    @Test
    @DataSet(value = "datasets/liquor.yml")
    @Transactional
    void すべてのリカーが取得できること() {
        List<Liquor> liquors = liquorMapper.findAll();
        assertThat(liquors)
                .hasSize(2)
                .contains(
                        new Liquor(1, "ウイスキー", "スコットランド", "マッカラン", 40),
                        new Liquor(2, "焼酎", "日本", "黒霧島", 25)
                );
    }

    @Test
    @DataSet(value = "datasets/liquor.yml")
    @Transactional
    void ID指定したリカーの情報を取得すること() {
        Optional<Liquor> liquor = liquorMapper.findById(1);
        assertThat(liquor)
                .contains(new Liquor(1, "ウイスキー", "スコットランド", "マッカラン", 40));
    }

    @Test
    @DataSet(value = "datasets/liquor.yml")
    @Transactional
    void 存在しないリカーIDを指定する場合に空の情報を取得すること() {
        Optional<Liquor> liquor = liquorMapper.findById(3);
        assertThat(liquor).isEmpty();
    }

}

package com.raisetech10.liquor_management.service;


import com.raisetech10.liquor_management.Exception.ResourceNotFoundException;
import com.raisetech10.liquor_management.entity.Liquor;
import com.raisetech10.liquor_management.mapper.LiquorMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class LiquorServiceImplTest {

    @InjectMocks//注入する（LiquorMapper→ LiquorServiceImpl）
    LiquorServiceImpl liquorServiceImpl;//テスト対象

    @Mock//スタブの対象↓
    LiquorMapper liquorMapper;

    //GETテストコード
    @Test
    public void findAllメソッドの呼び出しで存在する映画を全部取得すること() {
        List<Liquor> liquor = List.of(
                new Liquor(1, "ウイスキー", "スコットランド", "マッカラン", 40),
                new Liquor(2, "焼酎", "日本", "黒霧島", 25),
                new Liquor(3, "ブランデー", "フランス", "ヘネシーXO", 40)
        );
        doReturn(liquor).when(liquorMapper).findAll();
        List<Liquor> actual = liquorServiceImpl.findAll();
        assertThat(actual).isEqualTo(liquor);
        verify(liquorMapper, times(1)).findAll();
    }

    @Test
    public void 存在するリカーのIDを指定した時に正常にリカーが返されること() throws ResourceNotFoundException {
        doReturn(Optional.of(new Liquor(1, "ウイスキー", "スコットランド", "マッカラン", 40))).when(liquorMapper).findById(1);//スタブ内容

        Liquor actual = liquorServiceImpl.findById(1);
        assertThat(actual).isEqualTo(new Liquor(1, "ウイスキー", "スコットランド", "マッカラン", 40));
    }

    @Test
    public void 存在しないリカーのIDを指定した時に例外処理が動作すること() throws ResourceNotFoundException {
        doReturn(Optional.empty()).when(liquorMapper).findById(1000);
        assertThrows(ResourceNotFoundException.class, () -> {
            liquorServiceImpl.findById(1000);
        });
        verify(liquorMapper, times(1)).findById(1000);
    }


}

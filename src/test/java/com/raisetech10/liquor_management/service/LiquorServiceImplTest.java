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
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
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
        doReturn(Optional.of(new Liquor(1, "ウイスキー", "スコットランド", "マッカラン", 40)))
                .when(liquorMapper).findById(1);

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

    //POSTテストコード
    @Test
    public void 存在しないリカー情報を新規登録すること() {
        Liquor liquor = new Liquor(10, "ジン", "イギリス", "ビーフィーター", 40);
        doNothing().when(liquorMapper).insert(liquor);

        Liquor actual = liquorServiceImpl.createLiquor(liquor);
        assertThat(actual).isEqualTo(new Liquor(10, "ジン", "イギリス", "ビーフィーター", 40));
        verify(liquorMapper, times(1)).insert(liquor);
    }

    //PATCHテストコード
    @Test
    public void 存在するリカー情報を更新すること() {
        Liquor liquor = new Liquor(1, "ウイスキー", "スコットランド", "マッカラン", 40);
        doReturn(Optional.of(liquor))
                .when(liquorMapper).findLiquorId(1);
        doNothing().when(liquorMapper).update(new Liquor(1, "ビール", "日本", "アサヒスーパードライ", 5));

        Liquor actual = liquorServiceImpl.updateLiquor(1, "ビール", "日本", "アサヒスーパードライ", 5);
        assertThat(actual).isEqualTo(new Liquor(1, "ビール", "日本", "アサヒスーパードライ", 5));
        verify(liquorMapper, times(1)).findLiquorId(1);
    }

    @Test
    public void 存在するリカー情報の特定の属性を更新すること() {
        Liquor liquor = new Liquor(1, "ウイスキー", "スコットランド", "マッカラン", 40);
        doReturn(Optional.of(liquor))
                .when(liquorMapper).findLiquorId(1);

        // ウイスキーの名前をビールに変更して更新
        Liquor updatedLiquor = new Liquor(1, "ビール", liquor.getProducingCountry(), liquor.getLiquorName(), liquor.getAlcoholContent());
        doNothing().when(liquorMapper).update(updatedLiquor);

        Liquor actual = liquorServiceImpl.updateLiquor(1, "ビール", null, null, 0);
        assertThat(actual).isEqualTo(updatedLiquor);
        verify(liquorMapper, times(1)).findLiquorId(1);

    }

    @Test
    public void 存在しないリカー情報を更新する時の例外処理が動作すること() throws ResourceNotFoundException {
        doReturn(Optional.empty()).when(liquorMapper).findLiquorId(1000);

        assertThatThrownBy(
                () -> liquorServiceImpl.updateLiquor(1000, "ウォッカ", "ロシア", "スピリタス", 90)
        ).isInstanceOf(ResourceNotFoundException.class);
        verify(liquorMapper, times(1)).findLiquorId(1000);
    }

    //DELETEテストコード
    @Test
    public void 存在するリカー情報IDを削除すること() {
        Liquor liquor = new Liquor(1, "ウイスキー", "スコットランド", "マッカラン", 40);
        doReturn(Optional.of(liquor)).when(liquorMapper).findById(1);
        doNothing().when(liquorMapper).delete(1);
        liquorServiceImpl.deleteLiquor(1);
        verify(liquorMapper, times(1)).findById(1);
        verify(liquorMapper, times(1)).delete(1);
    }

    @Test
    public void 存在しないリカー情報を削除する時の例外処理が動作すること() throws ResourceNotFoundException {
        doReturn(Optional.empty()).when(liquorMapper).findById(1000);
        assertThrows(ResourceNotFoundException.class, () -> liquorServiceImpl.deleteLiquor(1000));
        verify(liquorMapper, times(1)).findById(1000);
        verify(liquorMapper, times(0)).delete(1000);

    }


}

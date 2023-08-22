import React from 'react';
import { Button, StyleSheet, Text, View } from 'react-native';

const SearchScreen = ({ navigation, route }) => {
  const { budget, timeRequired, concept } = route.params;

  const handleSavePlan = () => {
    // プランの保存処理
  };

  const handleChangeConditions = () => {
    // 条件変更処理
  };

  const handleRegenerate = () => {
    // 再生成処理
  };

  const handleAbort = () => {
    // 生成中断処理
  };

  return (
    <View style={styles.container}>
      <Text>検索結果</Text>
      <Text>予算: {budget}円</Text>
      <Text>所要時間: {timeRequired}分</Text>
      <Text>コンセプト: {concept}</Text>

      <Button title="プランを保存" onPress={handleSavePlan} />
      <Button title="条件変更・再生成" onPress={handleChangeConditions} />
      <Button title="生成中断" onPress={handleAbort} />
      <Button title="戻る" onPress={() => navigation.goBack()} />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});

export default SearchScreen;

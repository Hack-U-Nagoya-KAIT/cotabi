import React, { useEffect } from 'react';
import { Button, StyleSheet, Text, View } from 'react-native';

const UserScreen = ({ navigation }) => {
  useEffect(() => {
    console.log('User Mount');
    return () => {
      console.log('User Unmount');
    };
  }, []);

  return (
    <View style={styles.container}>
      <Text>ユーザ画面</Text>
      <Button
        title="旅の作成"
        color="#006881"
        onPress={() => {
          navigation.navigate('Prompt'); // PromptScreen に遷移する
        }}
      />
      <Text style={styles.description}>
        新しい旅のしおりを作成します
      </Text>
      <Button
        title="現在のプラン"
        color="#006881"
        onPress={() => {
          // 現在のプランボタンが押されたときの処理
        }}
      />
      <Text style={styles.description}>
        現在の旅のしおりを作成します
      </Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  description: {
    marginTop: 10,
    fontSize: 14,
    textAlign: 'center',
  },
});

export default UserScreen;

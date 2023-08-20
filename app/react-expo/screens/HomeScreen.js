import React from 'react';
import { Button, Text, View } from 'react-native';

const HomeScreen = ({ navigation }) => {
  return (
    <View>
      <Text>ホーム画面</Text>
      <Button title="ユーザ画面" onPress={() => navigation.navigate('User')} />
      <Button title="履歴画面" onPress={() => navigation.navigate('History')} />
      <Button title="設定画面" onPress={() => navigation.navigate('Setting')} />
    </View>
  );
};

export default HomeScreen;

import React, { useEffect } from 'react';
import { Text, View } from 'react-native';

const UserScreen = () => {
  useEffect(() =>{
    console.log('User Mount');
    return () => {
      console.log('User Unmount');
    };
  },[]);
  return (
    <View>
      <Text>ユーザ画面</Text>
    </View>
  );
};

export default UserScreen;
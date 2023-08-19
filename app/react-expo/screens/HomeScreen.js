import React, { useEffect } from 'react';
import { Button, Text, View } from 'react-native';

const HomeScreen = ({ navigation }) => {
  useEffect(() => {
    console.log('Home Mount');
    return () => {
      console.log('Home Unmount');
    };
  }, []);
  return (
    <View>
      <Text>ホーム画面</Text>
      <Button title="ホーム" onPress={() => navigation.navigate('User',{userId: 1,})}/>
    </View>
    
  );
};


export default HomeScreen;
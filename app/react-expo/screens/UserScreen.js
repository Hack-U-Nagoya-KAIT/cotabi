import { LinearGradient } from 'expo-linear-gradient';
import React, { useEffect } from 'react';
import { StyleSheet, Text, TouchableOpacity, View } from 'react-native';

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
      <TouchableOpacity
        style={styles.customButton}
        onPress={() => {
          navigation.navigate('Prompt'); // PromptScreen に遷移する
        }}
      >
        <LinearGradient
          colors={['#022534', '#08546C', '#A0BACC']}
          style={[styles.customButton, styles.createButton]}
        >
          <Text style={styles.buttonText}>旅の作成</Text>
        </LinearGradient>
      </TouchableOpacity>
      <Text style={styles.description}>
        新しい旅のしおりを作成します
      </Text>

      <TouchableOpacity
        style={styles.customButton}
        onPress={() => {
          navigation.navigate('Current');
        }}
      >
        <LinearGradient
          colors={['#022534', '#08546C', '#A0BACC']}
          style={[styles.customButton, styles.createButton2]}
        >
        <View style={styles.innerButton}>
          <Text style={styles.buttonText2}>現在のプラン</Text>
        </View>
        </LinearGradient>
      </TouchableOpacity>
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
    backgroundColor: '#E5DFD8',
  },
  customButton: {
    borderRadius: 34,
    overflow: 'hidden', // 必要ならオーバーフローを制御
    marginBottom: 10,
  },
  createButton: {
    width: 350, // ボタンの幅
    height: 40, // ボタンの高さ
    transform: [{ rotate: '0deg' }], // ボタンの回転
  },
  createButton2: {
    width: 350, // ボタンの幅
    height: 40, // ボタンの高さ
    transform: [{ rotate: '0deg' }], // ボタンの回転
  },
  gradientBackground: {
    paddingHorizontal: 20,
    paddingVertical: 10,
    alignItems: 'center',
    justifyContent: 'center',
  },
  innerButton: {
    borderRadius: 34,
    backgroundColor: '#FFF',
    paddingHorizontal: 20,
    paddingVertical: 10,
    alignItems: 'center',
    justifyContent: 'center',
    shadowColor: '#000',
    shadowOffset: {
      width: 0,
      height: 2,
    },
    shadowOpacity: 0.25,
    shadowRadius: 3.84,
    elevation: 5,
  },
  buttonText: {
    color: '#FFF', // 旅の作成ボタンのテキストの色
    fontWeight: 'bold',
    textAlign: 'center',
  },
  buttonText2: {
    color: '#006881', // 現在のプランボタンのテキストの色
    fontWeight: 'bold',
    textAlign: 'center',
  },
  description: {
    marginTop: 10,
    fontSize: 14,
    textAlign: 'center',
  },
});

export default UserScreen;

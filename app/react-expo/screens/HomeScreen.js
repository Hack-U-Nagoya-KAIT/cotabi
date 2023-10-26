import React from 'react';
import { StyleSheet, Text, TouchableOpacity, View } from 'react-native';

const FooterButton = ({ title, onPress }) => (
  <TouchableOpacity style={styles.footerButton} onPress={onPress}>
    <Text style={styles.footerButtonText}>{title}</Text>
  </TouchableOpacity>
);

const HomeScreen = ({ navigation }) => {
  return (
    <View style={styles.container}>
      <Text>ホーム画面</Text>
      {/* フッター */}
      <View style={styles.footer}>
        <FooterButton title="ユーザ画面" onPress={() => navigation.navigate('User')} />
        <FooterButton title="履歴画面" onPress={() => navigation.navigate('History')} />
        <FooterButton title="設定画面" onPress={() => navigation.navigate('Setting')} />
      </View>
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
  footer: {
    flexDirection: 'row',
    justifyContent: 'space-around',
    alignItems: 'center',
    width: '100%',
    height: 75,
    position: 'absolute',
    bottom: 0,
    backgroundColor: 'white',
    borderTopWidth: 1,
    borderColor: '#ddd',
  },
  footerButton: {
    paddingVertical: 10,
  },
  footerButtonText: {
    fontSize: 16,
  },
});

export default HomeScreen;

import { LinearGradient } from 'expo-linear-gradient';
import React from 'react';
import { StyleSheet, Text, TouchableOpacity, View } from 'react-native';

const CurrentPlanScreen = ({ navigation }) => {
  // 現在のプランのテキスト（仮のデータ）
  const currentPlanText = "ここに現在のプランのテキストを表示します。";

  const handleEdit = () => {
    // プラン編集画面に遷移する処理
    navigation.navigate('EditPlan');
  };

  const handleShare = () => {
    // プラン共有処理
  };

  return (
    <View style={styles.container}>
      <Text style={styles.heading}>現在のプラン</Text>
      <Text style={styles.currentPlanText}>{currentPlanText}</Text>

      <View style={styles.buttonContainer}>
        <TouchableOpacity style={styles.button} onPress={handleEdit}>
          <LinearGradient
            colors={['#022534', '#08546C', '#A0BACC']}
            style={styles.customButton}
          >
            <Text style={[styles.buttonText, { color: '#FFFFFF' }]}>編集</Text>
          </LinearGradient>
        </TouchableOpacity>
        <TouchableOpacity style={styles.button} onPress={handleShare}>
          <LinearGradient
            colors={['#FFFFFF', '#FFFFFF']}  // テキストの色を白に設定
            style={styles.customButton}
          >
            <Text style={[styles.buttonText, { color: '#08546C' }]}>共有</Text>
          </LinearGradient>
        </TouchableOpacity>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
  },
  heading: {
    fontSize: 20,
    fontWeight: 'bold',
    marginBottom: 10,
  },
  currentPlanText: {
    fontSize: 16,
    marginBottom: 20,
  },
  buttonContainer: {
    flexDirection: 'row',
    justifyContent: 'space-between',
  },
  button: {
    flex: 1,
    margin: 5,
  },
  customButton: {
    borderRadius: 34,
    overflow: 'hidden',
    paddingVertical: 10,
    paddingHorizontal: 20,
    backgroundColor: '#FFF',  // 背景を白に設定
  },
  buttonText: {
    fontWeight: 'bold',
    textAlign: 'center',
  },
});

export default CurrentPlanScreen;

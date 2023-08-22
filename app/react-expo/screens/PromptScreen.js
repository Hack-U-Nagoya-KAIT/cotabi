import React, { useState } from 'react';
import { Button, StyleSheet, Text, TextInput, View } from 'react-native';

const PromptScreen = ({ navigation }) => {
  const [budget, setBudget] = useState('');
  const [timeRequired, setTimeRequired] = useState('');
  const [concept, setConcept] = useState('');

  const handleSearch = () => {
    // ここに検索処理を追加
    
    // 検索結果画面に遷移
    navigation.navigate('SearchResult', {
      budget,
      timeRequired,
      concept,
    });
  };

  return (
    <View style={styles.container}>
      <Text style={styles.heading}>旅の作成</Text>
      <TextInput
        style={styles.input}
        placeholder="予算額"
        value={budget}
        onChangeText={setBudget}
        keyboardType="numeric"
      />
      <TextInput
        style={styles.input}
        placeholder="所要時間"
        value={timeRequired}
        onChangeText={setTimeRequired}
      />
      <TextInput
        style={styles.input}
        placeholder="コンセプト"
        value={concept}
        onChangeText={setConcept}
      />
      <Button title="検索する" onPress={handleSearch} />
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
  input: {
    borderWidth: 1,
    borderColor: '#ccc',
    padding: 10,
    marginBottom: 15,
  },
});

export default PromptScreen;

import { LinearGradient } from 'expo-linear-gradient';
import React, { useState } from 'react';
import { StyleSheet, Text, TextInput, TouchableOpacity, View } from 'react-native';

const PromptScreen = ({ navigation }) => {
  const [budget, setBudget] = useState('');
  const [hours, setHours] = useState('');
  const [minutes, setMinutes] = useState('');
  const [concept, setConcept] = useState('');

  const handleSearch = () => {
    // 時間と分を合計して所要時間を算出
    const timeRequired = parseInt(hours) * 60 + parseInt(minutes);

    // 検索結果画面に遷移
    navigation.navigate('Search', {
      budget: budget,
      timeRequired: timeRequired,
      concept: concept,
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
      <Text style={styles.unit}>円</Text>
      
      <View style={styles.timeInputContainer}>
        <TextInput
          style={styles.timeInput}
          placeholder="時間"
          value={hours}
          onChangeText={setHours}
          keyboardType="numeric"
        />
        
        <Text>時間</Text>
        <TextInput
          style={styles.timeInput}
          placeholder="分"
          value={minutes}
          onChangeText={setMinutes}
          keyboardType="numeric"
        />
        <Text>分</Text>
      </View>
      <TextInput
        style={styles.input}
        placeholder="コンセプト"
        value={concept}
        onChangeText={setConcept}
      />
      <TouchableOpacity
        style={styles.customButton}
        onPress={handleSearch}
      >
        <LinearGradient
          colors={['#022534', '#08546C', '#A0BACC']}
          style={[styles.customButton, styles.createButton]}
        >
          <Text style={styles.buttonText}>検索する</Text>
        </LinearGradient>
      </TouchableOpacity>
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
  unit: {
    marginBottom: 15,
  },
  timeInputContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 15,
  },
  timeInput: {
    flex: 1,
    borderWidth: 1,
    borderColor: '#ccc',
    padding: 10,
  },
  customButton: {
    borderRadius: 34,
    overflow: 'hidden',
    marginBottom: 10,
  },
  createButton: {
    width: 350,
    height: 40,
    transform: [{ rotate: '0deg' }],
  },
  buttonText: {
    color: '#FFF',
    fontWeight: 'bold',
    textAlign: 'center',
  },
});

export default PromptScreen;

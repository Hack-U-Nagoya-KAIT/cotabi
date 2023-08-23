import React from 'react';
import { Text, View, StyleSheet, ScrollView } from 'react-native';

const CurrentScreen = () => {
  return (
    <View style = {styles.container}>
      <View style = {[{flex:1}, {alignSelf:'stretch'}]}>
      <Text style = {styles.title}>現在のプラン画面</Text>
        <ScrollView style = {styles.outputScrollView} showsVerticalScrollIndicator = {true}>
          <Text style = {styles.outputText}>Hello, World! Nice to meet you! This is OutputText and ScrollView!</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
          <Text style = {styles.outputText}>OutputText</Text>
        </ScrollView>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex:1,
    alignItems:'center',
    justifyContent:'center',
    backgroundColor:'#E5DFD8',
  },
  title: {
    marginTop:16,
    marginBottom:0,
    textAlign:'center',
    fontSize:16,
  },
  outputScrollView: {
    margin:16,
    alignSelf:'stretch',
    textAlign:"left",
    backgroundColor:'#EFE8E5',
    borderColor:'#000000',
    borderWidth:2,
    borderRadius:16,
    padding:8,
  },
  outputText: {
    fontSize:16,
  }
});

export default CurrentScreen;

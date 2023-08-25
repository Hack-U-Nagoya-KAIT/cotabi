import MaskedView from '@react-native-masked-view/masked-view';
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
      {/* <Text>ユーザ画面</Text> */}
      <View style = {{alignSelf:'stretch'}}>
        <TouchableOpacity
          style={[styles.primaryButtonLayout, styles.buttonShadow]}
          onPress={() => {
            navigation.navigate('Prompt'); // PromptScreen に遷移する
          }}
        >
          <LinearGradient
            colors={['#022534', '#08546C', '#A0BACC']}
            start={{x:0.0, y:0.5}}
            end={{x:1.0, y:0.5}}
            style={styles.primaryButton}
          >
            <Text style={styles.primaryButtonText}>旅の作成</Text>
          </LinearGradient>
        </TouchableOpacity>
      </View>
      <Text style={styles.description}>
        新しい旅のしおりを作成します
      </Text>
      <View style =  {{margin:20,}} />
      <TouchableOpacity 
        style={[styles.secondaryButtonLayout, styles.buttonShadow]}
        onPress={() => {
          //navigation.navigate('Current');
        }}
      >
        <LinearGradient
          colors={['#022534', '#08546C', '#A0BACC']} 
          start={{x:0.0, y:0.5}}
          end={{x:1.0, y:0.5}}
          style={{borderRadius: 33}}
        >
          <View style = {styles.secondaryButton}>
            <GradientText style={styles.secondaryButtonText}>現在のしおりを確認</GradientText>
          </View>
        </LinearGradient>
      </TouchableOpacity>
      <Text style={styles.description}>
        現在の旅のしおりを表示します
      </Text>
    </View>
  );
};

const GradientText = props => {
  return (
    <MaskedView maskElement={<Text {...props} />}>
      <LinearGradient
        colors={['#022534', '#08546C', '#A0BACC']} 
        start={{x:0, y:0}}
        end={{x:1, y:0}}>
          <Text {...props} style={[props.style, {opacity: 0}]} />
        </LinearGradient>
    </MaskedView>
  )
}

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
  description: {
    margin:8,
    fontSize: 16,
    textAlign: 'center',
  },
  primaryButtonLayout: {
    alignSelf:'stretch',
    marginHorizontal:16,
    marginVertical:8,
    backgroundColor:"#E5DFD8",
    borderRadius:33,
  },
  primaryButton: {
    borderStyle:'solid',
    borderColor:'#FFFFFF',
    borderWidth:1,
    borderRadius:33,
  },
  primaryButtonText: {
    textAlign:'center',
    margin:16,
    color:'#FFFFFF',
    fontSize:16,
    fontWeight:'bold',
  },
  secondaryButtonLayout: {
    alignSelf:'stretch',
    marginHorizontal:16,
    marginVertical:8,
    backgroundColor:"#E5DFD8",
    borderRadius:33,
  },
  secondaryButton: {
    margin:2,
    backgroundColor:"#ffffff",
    borderRadius:33,
  },
  secondaryButtonText: {
    textAlign:"center",
    margin:16,
    fontSize:16,
    fontWeight:'bold'
  },
  buttonShadow: {
    shadowColor:'#000',
    shadowOffset:{width:2, height:2},
    shadowOpacity:0.5,
    shadowRadius: 2,
  },

});

export default UserScreen;

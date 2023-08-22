import axios from 'axios';
import * as Location from 'expo-location';
import React, { useState } from 'react';
import { Button, Text, View } from 'react-native';

function GeolocationScreen() {
    const [location, setLocation] = useState(null);

    const getGeolocation = async () => {
        let { status } = await Location.requestForegroundPermissionsAsync();
        if (status !== 'granted') {
            console.error('位置情報のアクセスが許可されていません');
            return;
        }

        let location = await Location.getCurrentPositionAsync({});
        setLocation(location);

        try {
            const response = await axios.post(' https://fae2-202-250-70-11.ngrok-free.app/api/location', {
                latitude: location.coords.latitude,
                longitude: location.coords.longitude
            });

            console.log('サーバーレスポンス:', response.data);
        } catch (error) {
            console.error('データの送信に失敗しました:', error);
        }
    };

    return (
        <View>
            <Button title="位置情報取得" onPress={getGeolocation} />
            {location && (
                <Text>
                    緯度: {location.coords.latitude}, 経度: {location.coords.longitude}
                </Text>
            )}
        </View>
    );
}

export default GeolocationScreen;
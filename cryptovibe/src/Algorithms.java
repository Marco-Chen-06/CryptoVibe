

import java.util.ArrayList;

public class Algorithms
{
    public static int whereToPlace(String value, ArrayList<String> list) {
        int index = list.size();
        boolean stop = false;
        for (int i = 0; !stop && i < list.size(); i++) {
            if (value.compareToIgnoreCase(list.get(i)) <= 0) {
                index = i;
                stop = true;
            }
        }
        return index;
    }

    public static int whereToPlaceReverse(String value, ArrayList<String> list) {
        int index = list.size();
        boolean stop = false;
        for (int i = 0; !stop && i < list.size(); i++) {
            if (value.compareToIgnoreCase(list.get(i)) >= 0) {
                index = i;
                stop = true;
            }
        }
        return index;
    }

    public static ArrayList<ArrayList<String>> sortAlphabetically(ArrayList<String> songs, ArrayList<String> albums) {
        ArrayList<String> songList = new ArrayList<String>();
        ArrayList<String> albumList = new ArrayList<String>();
        for (int i = 0; i < 15; i++) {
            if (i == 0) {
                songList.add(songs.get(i));
                albumList.add(albums.get(i));
            } else {
                songList.add(whereToPlace(songs.get(i), songList), songs.get(i));
                albumList.add(whereToPlace(songs.get(i), songList), albums.get(i));
            }
        }
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        list.add(songList);
        list.add(albumList);
        return list;
    }

    public static ArrayList<ArrayList<String>> sortReverseAlphabetically(ArrayList<String> songs, ArrayList<String> albums) {
        ArrayList<String> songList = new ArrayList<String>();
        ArrayList<String> albumList = new ArrayList<String>();
        for (int i = 0; i < 15; i++) {
            if (i == 0) {
                songList.add(songs.get(i));
                albumList.add(albums.get(i));
            } else {
                songList.add(whereToPlaceReverse(songs.get(i), songList), songs.get(i));
                albumList.add(whereToPlaceReverse(songs.get(i), songList), albums.get(i));
            }
        }
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        list.add(songList);
        list.add(albumList);
        return list;
    }


    public static int findSong(ArrayList<String> list, String name) {
        int index = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(name)) {
                index = i;
            }
        }
        return index;
    }
    public static ArrayList<String> shuffle(ArrayList<String> old) {
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < old.size(); i++) {
            temp.add(old.get(i));
        }
        ArrayList<String> result = new ArrayList<String>();
        while (temp.size() > 0) {
            int randIndex = (int) (Math.random()*temp.size());
            result.add(temp.remove(randIndex));
        }
        return result;
    }
    public static ArrayList<String> fullSongList(ArrayList<String> songNames, ArrayList<String> wavFiles) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < songNames.size(); i++) {
            result.add(wavFiles.get(findSongWav(songNames.get(i), wavFiles)));
        }
        return result;
    }

    public static int findSongWav(String text, ArrayList<String> wavFiles) {
        int index = wavFiles.size();
        for (int i = 0; i < wavFiles.size(); i++) {
            if (wavFiles.get(i).substring(0,3).equals("Thu") || wavFiles.get(i).substring(0,3).equals("Thr")) {
                if (wavFiles.get(i).substring(0,3).equals(text.substring(0,3))) {
                    index = i;
                }
            } else {
                if (wavFiles.get(i).substring(0,2).equals(text.substring(0,2))) {
                    index = i;
                }
            }
        }
        return index;
    }

}
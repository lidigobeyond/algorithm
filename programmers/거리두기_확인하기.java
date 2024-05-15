import java.util.ArrayList;
import java.util.List;

class Solution {
    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};

    final static char PARTICIPANT = 'P';
    final static char EMPTY = 'O';
    final static char PARTITION = 'X';

    private boolean isNextToParticipant(char[][] room, int y, int x, int excluded) {
        for(int d = 0; d < 4; d++) {
            if (d == excluded) {
                continue;
            }

            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) {
                continue;
            }

            if (room[ny][nx] == PARTICIPANT) {
                return true;
            }
        }

        return false;
    }

    /**
     * 응시자가 거리두기를 지키고 있는지 확인합니다.
     * @param room
     * @param y
     * @param x
     * @return
     */
    private boolean isDistanced(char[][] room, int y, int x) {
       for(int d = 0; d < 4; d++) {
           int ny = y + dy[d];
           int nx = x + dx[d];

           if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) {
               continue;
           }

           switch (room[ny][nx]) {
               case PARTICIPANT:
                   return false;
               case PARTITION:
                   continue;
               case EMPTY:
                   if (isNextToParticipant(room, ny, nx, (d+2)%4)) {
                       return false;
                   }
           }
       }

       return true;
    }

    /**
     * 대기실에 거리두기가 잘 지켜지고 있는지 확인합니다.
     * @param room
     * @return
     */
    private int isDistanced(char[][] room) {
        for(int y = 0; y < room.length; y++) {
            for(int x = 0; x < room[y].length; x++) {
                if (room[y][x] != PARTICIPANT) {
                    continue;
                }

                if (!isDistanced(room, y, x)) {
                    return 0;
                }
            }
        }

        return 1;
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int i = 0; i < answer.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];

            for(int j = 0; j < place.length; j++) {
                room[j] = place[j].toCharArray();
            }

            answer[i] = isDistanced(room);
        }

        return answer;
    }
}
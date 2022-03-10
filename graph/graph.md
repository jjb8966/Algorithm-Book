# 그래프 탐색(DFS & BFS)

# 1. 그래프

---

- 정점(Vertex)와 간선(Edge)로 구성되어 있음
- 그래프 표현 방식
    1. 인접 행렬(Adjacency Matrix)
        - 2차원 배열로 그래프의 연결 관계를 표현
        - 연결된 두 정점을 빠르게 확인할 수 있음
        - 메모리가 불필요하게 낭비됨
    2. 인접 리스트(Adjacency List)
        - 각 노드의 연결된 노드를 리스트 형식으로 표현
        - 연결된 정보만 저장하기 때문에 메모리를 효율적으로 사용함

# 2. DFS(Depth First Search)

---

> 그래프에서 깊은 부분을 우선적으로 탐색하는 알고리즘
>
- 스택 자료구조를 사용함
    - 스택 자료 구조를 사용할 때는 재귀 함수를 활용함
- 동작 과정
    1. 시작 노드를 스택에 삽입하고 방문 처리
    2. 스택 최상단 노드에 대해 방문하지 않은 인접한 노드가 있으면 그 인접 노드를 스택에 넣고 방문 처리
    3. 방문하지 않은 인접노드가 없다면 최상단 노드를 꺼냄
    4. 스택이 빌 때 까지 반복
- 코드

    ```java
    // DFS 함수 정의
        public static void dfs(int x) {
            // 현재 노드를 방문 처리
            visited[x] = true;
            System.out.print(x + " ");
            // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!visited[y]) dfs(y);
            }
        }
    ```

    - dfs 메소드를 호출하는 것 자체가 스택을 이용하는 것
    - 여기서 x가 스택의 최상단 노드
    - for문 안에 y는 x에 인접한 노드이고 if문으로 y가 방문처리 되어있는지 유무에 따라 스택에 넣을지 말지(재귀 함수 호출을 할지 말지) 결정함
    - x의 인접한 노드 y가 모두 방문 처리 되어있으면 해당 메소드는 종료되고 스택에서 꺼내짐

# 3. BFS (Breadth First Search)

---

> 그래프에서 가까운 부분부터 탐색해 나가는 알고리즘
>
- 큐 자료구조를 이용함
- 동작 과정
    1. 시작 노드를 큐에 넣고 방문 처리
    2. 큐에서  노드를 꺼내 인접 노드 중 방문하지 않은 `모든` 노드를 큐에 삽입하고 방문 처리
    3. 큐가 빌 때까지 반복
- 코드

    ```java
    // BFS 함수 정의
        public static void bfs(int start) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(start);
            // 현재 노드를 방문 처리
            visited[start] = true;
            // 큐가 빌 때까지 반복
            while(!q.isEmpty()) {
                // 큐에서 하나의 원소를 뽑아 출력
                int x = q.poll();
                System.out.print(x + " ");
                // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
                for(int i = 0; i < graph.get(x).size(); i++) {
                    int y = graph.get(x).get(i);
                    if(!visited[y]) {
                        q.offer(y);
                        visited[y] = true;
                    }
                }
            }
        }
    ```

    - DFS와 달리 큐를 직접 만들어줘야 함
    - while문을 사용해 반복
    - if문 안에 재귀 함수 호출이 아닌 큐에 노드를 삽입하고 방문 처리하는 작업을 함
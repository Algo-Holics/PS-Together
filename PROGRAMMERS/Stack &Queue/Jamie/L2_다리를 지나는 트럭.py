from collections import deque


def solution(bridge_length, weight, truck_weights):

    time = 0
    # 다리의 길이만큼 0으로 이뤄진 리스트를 만든다
    bridge = [0] * bridge_length

    while bridge:
        time += 1
        # 먼저 다리의 맨 앞칸을 빼고
        bridge.pop(0)
        # 만약 트럭이 남아있으면
        if truck_weights:
            # 현재 다리에 있는 트럭의 무게와 남은 트럭 리스트의 맨 앞 트럭의 무게의 합이 
            # 최대무게를 안넘으면 다리에 트럭을 싣는다 (트럭 리스트에서는 빼준다)
            if sum(bridge) + truck_weights[0] <= weight:
                bridge.append(truck_weights.pop(0))
            # 최대 무게를 넘는다면 아직 트럭이 남아있으니까 아까 뺀 다리 앞 부분을 다시 붙여준다
            else:
                bridge.append(0)

    return time


solution(2, 10, [7,4,5,6])
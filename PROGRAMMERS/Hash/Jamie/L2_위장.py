'''
애초에 각 카테고리마다 "안 입는 경우"의 케이스를 넣어준다
ex) 상의: 빨강, 노랑, 안입 / 하의: 파랑, 안입
==> (빨강, 파랑) / (빨강, 안입) / (노랑, 파랑) / (노랑, 안입) / (안입, 파랑) / (안입, 안입)
딱 한 가지만 입는 경우는 "안입"이 포함되어 있게 된다
이렇게 구한 전체 케이스에서 (안입, 안입) 케이스 1개를 빼주면된다
'''


def solution(clothes):
    wardrobe = {}
    for c in clothes:
        name, category = c[0], c[1]
        if category in wardrobe:
            value = wardrobe.get(category)
            wardrobe[category] = value + 1
        else:
            # 시작부터 (안입, 안입) 케이스의 개수까지 포함해서 넣어줌
            wardrobe[category] = 2

    total = 1
    for v in wardrobe.values():
        total *= v
    # 마지막에 (안입, 안입) 케이스를 빼준다
    return total-1
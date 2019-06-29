import csv

class Pro:

    def __init__(self, name):
        self.name = name
        self.deadzone_shape = []
        self.deadzone = []
        self.dodge_deadzone= []
        self.aerial_sensitivity = []
        self.steering_sensitivity = []
        self.powerslide = []
        self.air_roll = []
        self.boost = []
        self.jump = []
        self.ball_cam = []
        self.brake = []
        self.throttle = []
        self.camera_shake = []
        self.fov = []
        self.height = []
        self.angle = []
        self.distance = []
        self.stiffness = []
        self.swivel_speed = []
        self.transition_speed = []
        self.ball_camera = []        


    path = r'D:\CODE\RocketLeagueConfigs\pro_camera_settings.csv'
    print("NAME?")
    player_name = input()

    with open(path) as csvfile:

        so = csv.reader(csvfile, delimiter=',')
        sort = sorted(so)

        for i in sort:
            if player_name == i[0]:
                deadzone_shape = i[1]
                deadzone = i[2]
                dodge_deadzone = i[3]
                aerial_sensitivity = i[4]
                steering_sensitivity = i[5]
                powerslide = i[6]
                air_roll = i[7]
                boost = i[8]
                jump = i[9]
                ball_cam = i[10]
                brake = i[11]
                throttle = i[12]
                camera_shake = i[13]
                fov = i[14]
                height = i[15]
                angle = i[16]
                distance = i[17]
                stiffness = i[18]
                swivel_speed = i[19]
                transition_speed = i[20]
                ball_camera = i[21]

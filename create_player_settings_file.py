import csv
import string
from configobj import ConfigObj
try:
    from configparser import ConfigParser
except ImportError:
    from ConfigParser import ConfigParser  # ver. < 3.0


print("yo")
print("NAME?")
get_player_name = input()


def get_player_settings(player_name):
    path = r'D:\CODE\RocketLeagueConfigs\pro_camera_settings.csv'
    with open(path) as csvfile:

        so = csv.reader(csvfile, delimiter=',')
        sort = sorted(so)
        settings_list = {}

        for i in sort:
            if player_name == i[0]:
                deadzone_shape = i[1]

                deadzone = i[2]
                settings_list["GamepadDeadzone="] = i[2]

                dodge_deadzone = i[3]

                aerial_sensitivity = i[4]

                steering_sensitivity = i[5]

                powerslide = i[6]
                settings_list['GamepadBindings=( Action="Handbrake"'] = i[6]

                air_roll = i[7]
                # settings_list['GamepadBindings=( Action="ToggleRoll"'] = i[7]

                boost = i[8]
                settings_list['GamepadBindings=( Action="Boost"'] = i[8]
                

                jump = i[9]
                settings_list['GamepadBindings=( Action="Jump"'] = i[9]

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

        print(deadzone)
        return settings_list


def edit_config(config_list):
    f = open('test.ini', 'r')
    lines = f.readlines()


    for key in config_list:
        line_number = -1
        for line in lines:
            line_number += 1
            if line.find(key) != -1:
                if line.find("XboxTypeS_") != -1:
                    raw_string = line.split(",")
                    new_string = raw_string[0] + ',' + ' Key="XboxTypeS_' + \
                        config_list.get(key) + '", ' + raw_string[2]
                    lines[line_number] = new_string

                elif line.find("AxisSign=AxisSign_") !=-1:
                    raw_string = line.split(",")
                    new_string = raw_string[0] + ',' + ' '

                else:
                    print(line_number)
                    lines[line_number] = key + config_list.get(key) + "\n"
                    print("done")
    f.close()

    f = open('test.ini', 'w')
    f.writelines(lines)
    f.close()
    return

edit_config(get_player_settings(get_player_name))

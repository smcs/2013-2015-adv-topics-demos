//
//  OpenGL_01____Three_Cuboid_ObjectsAppDelegate.h
//  OpenGL 01.++ Three Cuboid Objects
//
//  Created by Seth Battis on 3/9/11.
//  Copyright __MyCompanyName__ 2011. All rights reserved.
//

#import <UIKit/UIKit.h>

@class GLView;

@interface ThreeCuboidObjectsAppDelegate : NSObject <UIApplicationDelegate> {
    UIWindow *window;
    GLView *glView;
}

@property (nonatomic, retain) IBOutlet UIWindow *window;
@property (nonatomic, retain) IBOutlet GLView *glView;

@end


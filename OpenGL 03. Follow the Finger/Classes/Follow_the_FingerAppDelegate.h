//
//  Follow_the_FingerAppDelegate.h
//  Follow the Finger
//
//  Created by Seth Battis on 3/11/11.
//  Copyright __MyCompanyName__ 2011. All rights reserved.
//

#import <UIKit/UIKit.h>

@class GLView;

@interface Follow_the_FingerAppDelegate : NSObject <UIApplicationDelegate> {
    UIWindow *window;
    GLView *glView;
}

@property (nonatomic, retain) IBOutlet UIWindow *window;
@property (nonatomic, retain) IBOutlet GLView *glView;

@end

